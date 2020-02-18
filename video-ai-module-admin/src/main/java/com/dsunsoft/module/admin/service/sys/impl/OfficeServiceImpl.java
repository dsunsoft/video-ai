package com.dsunsoft.module.admin.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.entity.TreeValue;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.OfficeMapper;
import com.dsunsoft.module.admin.entity.sys.Office;
import com.dsunsoft.module.admin.entity.sys.OfficeTree;
import com.dsunsoft.module.admin.service.sys.OfficeService;

@Service
public class OfficeServiceImpl extends BaseServiceImpl<OfficeMapper, Office, String> implements OfficeService {
    
    
     // 收缩图标
    private static String FA_FOLDER = "ui-icon-folder";

    // 扩展图标
    private static String FA_FOLDER_OPEN = "ui-icon-folder-open";
	
	@Override
    public List<Tree> selectTree(Office area) {
        ArrayList<Tree> listTree = new ArrayList<Tree>();
        List<Office> listAll = mapper.findList(area);
        if (listAll != null && listAll.size()>0) {
            String areaType = listAll.get(0).getType() != null?listAll.get(0).getType():"1";
            List<Office> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
            if (first != null) {
                for (Office menu : first) {
                    Tree newTree = new Tree();
                    newTree.setLabel(menu.getName());
                    TreeValue treeValue = new TreeValue();
                    treeValue.setValue(menu.getId());
                    treeValue.setLevel(Integer.valueOf(menu.getType()));
                    newTree.setData(treeValue);
                    newTree.setCollapsedIcon(FA_FOLDER);
                    newTree.setExpandedIcon(FA_FOLDER_OPEN);
                    newTree.setExpanded(true);
                    listTree.add(newTree);

                    procTree(listAll, menu.getId(), newTree);
                }
            }
        }
        return listTree;
    }
    
    
    @Override
    public List<NzTree> selectNzTree(Office area) {
        ArrayList<NzTree> listTree = new ArrayList<NzTree>();
        List<Office> listAll = mapper.findList(area);
        if (listAll != null && listAll.size()>0) {
            String areaType = listAll.get(0).getType() != null?listAll.get(0).getType():"1";
            List<Office> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
            if (first != null) {
                for (Office menu : first) {
                    NzTree newTree = new NzTree();
                    newTree.setKey(menu.getId());
                    newTree.setTitle(menu.getName());
                    newTree.setExpanded(true);
                    newTree.setOrigin(menu);
                    listTree.add(newTree);
                    procTree(listAll, menu.getId(), newTree);
                }
            }
        }
        return listTree;
    }

    private void procTree(List<Office> lst, String id, NzTree tree) {
        List<Office> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
        ArrayList<NzTree> listChildren = new ArrayList<NzTree>();
        if(list != null && list.size()>0) {
            for (Office area : list) {
                NzTree newTree = new NzTree();
                newTree.setTitle(area.getName());
                newTree.setKey(area.getId());
                newTree.setExpanded(false);
                newTree.setOrigin(area);
                listChildren.add(newTree);
                procTree(lst, area.getId(), newTree);
            }
        }
        else {
            tree.setIsLeaf(true);
        }
        tree.setChildren(listChildren);
    }

    private void procTree(List<Office> lst, String id, Tree tree) {
        List<Office> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
        ArrayList<Tree> listChildren = new ArrayList<Tree>();
        for (Office area : list) {
            Tree newTree = new Tree();
            newTree.setLabel(area.getName());
            TreeValue treeValue = new TreeValue();
            treeValue.setValue(area.getId());
            treeValue.setLevel(Integer.valueOf(area.getType()));
            newTree.setData(treeValue);
            newTree.setCollapsedIcon(FA_FOLDER);
            newTree.setExpandedIcon(FA_FOLDER_OPEN);
            newTree.setExpanded(false);
            listChildren.add(newTree);
            procTree(lst, area.getId(), newTree);
        }
        tree.setChildren(listChildren);
    }

    @Override
    public List<OfficeTree> selectListTree(Office sysMenu) {
        // TODO Auto-generated method stub
        ArrayList<OfficeTree> listTree = new ArrayList<OfficeTree>();
        List<Office> listAll = mapper.findList(sysMenu);
        if (listAll != null && listAll.size()>0) {
            String areaType = listAll.get(0).getType() != null?listAll.get(0).getType():"1";
            List<Office> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
            if (first != null) {
                for (Office menu : first) {
                    OfficeTree newTree = new OfficeTree();
                    newTree.setLabel(menu.getName());
                    newTree.setData(menu);
                    newTree.setCollapsedIcon(FA_FOLDER);
                    newTree.setExpandedIcon(FA_FOLDER_OPEN);
                    newTree.setExpanded(true);
                    listTree.add(newTree);
                    procTree(listAll, menu.getId(), newTree);
                }
            }
        }
        return listTree;
    }
    
    
    private void procTree(List<Office> lst, String id, OfficeTree tree) {

        List<Office> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
        ArrayList<OfficeTree> listChildren = new ArrayList<OfficeTree>();
        for (Office sysMenu : list) {
            OfficeTree newTree = new OfficeTree();
            newTree.setLabel(sysMenu.getName());
            newTree.setData(sysMenu);
            newTree.setCollapsedIcon(FA_FOLDER);
            newTree.setExpandedIcon(FA_FOLDER_OPEN);
            newTree.setExpanded(false);
            listChildren.add(newTree);

            procTree(lst, sysMenu.getId(), newTree);
        }
        tree.setChildren(listChildren);
    }

}

