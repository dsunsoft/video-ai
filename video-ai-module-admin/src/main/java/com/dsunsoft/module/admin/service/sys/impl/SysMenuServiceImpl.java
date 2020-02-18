package com.dsunsoft.module.admin.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.entity.TreeValue;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.SysMenuMapper;
import com.dsunsoft.module.admin.entity.sys.SysMenu;
import com.dsunsoft.module.admin.entity.sys.SysMenuTree;
import com.dsunsoft.module.admin.service.sys.SysMenuService;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu, String> implements SysMenuService {
	@Autowired
	private SysMenuMapper dao;

	// 收缩图标
	private static String FA_FOLDER = "ui-icon-folder";

	// 扩展图标
	private static String FA_FOLDER_OPEN = "ui-icon-folder-open";

	public List<SysMenuTree> selectListTree(SysMenu sysMenu) {
		ArrayList<SysMenuTree> listTree = new ArrayList<SysMenuTree>();
		List<SysMenu> listAll = dao.findList(sysMenu);
		if (listAll != null) {
			List<SysMenu> first = listAll.stream().filter(i -> i.getLevel() == 1).collect(Collectors.toList());
			if (first != null) {
				for (SysMenu menu : first) {
					SysMenuTree newTree = new SysMenuTree();
					newTree.setLabel(menu.getMenuName());
					newTree.setData(menu);
					newTree.setCollapsedIcon(FA_FOLDER);
					newTree.setExpandedIcon(FA_FOLDER_OPEN);
					newTree.setExpanded(false);
					listTree.add(newTree);

					procTree(listAll, menu.getMenuId(), newTree);
				}
			}
		}
		return listTree;
	}

	@Override
	public List<Tree> selectTree(SysMenu sysMenu) {
		List<Tree> listMenuTree = new ArrayList<Tree>();

		ArrayList<Tree> listTree = new ArrayList<Tree>();
		Tree tree = new Tree();
		tree.setChildren(listTree);
		tree.setLabel("功能菜单");
		tree.setCollapsedIcon(FA_FOLDER);
		tree.setExpandedIcon(FA_FOLDER_OPEN);
		tree.setExpanded(true);
		TreeValue value = new TreeValue();
		value.setValue("");
		tree.setData(value);
		listMenuTree.add(tree);

		List<SysMenu> listAll = dao.findList(sysMenu);
		if (listAll != null) {
			List<SysMenu> first = listAll.stream().filter(i -> i.getLevel() == 1).collect(Collectors.toList());
			if (first != null) {
				for (SysMenu menu : first) {
					Tree newTree = new Tree();
					newTree.setLabel(menu.getMenuName());
					TreeValue treeValue = new TreeValue();
					treeValue.setValue(menu.getMenuId());
					treeValue.setLevel(menu.getLevel().intValue());
					newTree.setData(treeValue);
					newTree.setCollapsedIcon(FA_FOLDER);
					newTree.setExpandedIcon(FA_FOLDER_OPEN);
					newTree.setExpanded(false);
					listTree.add(newTree);

					procTree(listAll, menu.getMenuId(), newTree);
				}
			}
		}
		return listMenuTree;
	}
	
	
	@Override
    public List<NzTree> selectNzTree(SysMenu sysMenu) {
        List<NzTree> listMenuTree = new ArrayList<NzTree>();
        ArrayList<NzTree> listTree = new ArrayList<NzTree>();
        NzTree tree = new NzTree();
        tree.setChildren(listTree);
        tree.setTitle("功能菜单");
        tree.setExpanded(true);
        tree.setKey("rootKey");
        listMenuTree.add(tree);
        List<SysMenu> listAll = dao.findList(sysMenu);
        if (listAll != null) {
            List<SysMenu> first = listAll.stream().filter(i -> i.getLevel() == 1).collect(Collectors.toList());
            if (first != null) {
                for (SysMenu menu : first) {
                    NzTree newTree = new NzTree();
                    newTree.setKey(menu.getMenuId());
                    newTree.setTitle(menu.getMenuName());
                    newTree.setExpanded(false);
                    newTree.setOrigin(menu);
                    listTree.add(newTree);
                    procTree(listAll, menu.getMenuId(), newTree);
                }
            }
        }
        return listMenuTree;
    }

    private void procTree(List<SysMenu> lst, String id, NzTree tree) {
        List<SysMenu> list = lst.stream().filter(i -> i.getPid().equals(id)).collect(Collectors.toList());
        ArrayList<NzTree> listChildren = new ArrayList<NzTree>();
        if(list != null && list.size()>0) {
            for (SysMenu sysMenu : list) {
                NzTree newTree = new NzTree();
                newTree.setTitle(sysMenu.getMenuName());
                newTree.setKey(sysMenu.getMenuId());
                newTree.setExpanded(false);
                newTree.setOrigin(sysMenu);
                listChildren.add(newTree);
                procTree(lst, sysMenu.getMenuId(), newTree);
            }
        }
        else {
            tree.setIsLeaf(true);
        }
        tree.setChildren(listChildren);
    }

	private void procTree(List<SysMenu> lst, String id, Tree tree) {

		List<SysMenu> list = lst.stream().filter(i -> i.getPid().equals(id)).collect(Collectors.toList());
		ArrayList<Tree> listChildren = new ArrayList<Tree>();
		for (SysMenu sysMenu : list) {
			Tree newTree = new Tree();
			newTree.setLabel(sysMenu.getMenuName());
			TreeValue treeValue = new TreeValue();
			treeValue.setValue(sysMenu.getMenuId());
			treeValue.setLevel(sysMenu.getLevel().intValue());
			newTree.setData(treeValue);
			newTree.setCollapsedIcon(FA_FOLDER);
			newTree.setExpandedIcon(FA_FOLDER_OPEN);
			newTree.setExpanded(false);
			listChildren.add(newTree);

			procTree(lst, sysMenu.getMenuId(), newTree);
		}
		tree.setChildren(listChildren);
	}
	
	
	
	

	private void procTree(List<SysMenu> lst, String id, SysMenuTree tree) {

		List<SysMenu> list = lst.stream().filter(i -> i.getPid().equals(id)).collect(Collectors.toList());
		ArrayList<SysMenuTree> listChildren = new ArrayList<SysMenuTree>();
		for (SysMenu sysMenu : list) {
			SysMenuTree newTree = new SysMenuTree();
			newTree.setLabel(sysMenu.getMenuName());
			newTree.setData(sysMenu);
			newTree.setCollapsedIcon(FA_FOLDER);
			newTree.setExpandedIcon(FA_FOLDER_OPEN);
			newTree.setExpanded(false);
			listChildren.add(newTree);

			procTree(lst, sysMenu.getMenuId(), newTree);
		}
		tree.setChildren(listChildren);
	}

}
