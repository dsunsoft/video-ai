package com.dsunsoft.module.admin.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dsunsoft.common.entity.ng.NgCascader;
import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.common.enums.AreaType;
import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.entity.TreeValue;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.AreaMapper;
import com.dsunsoft.module.admin.dto.AreaSearchDto;
import com.dsunsoft.module.admin.entity.sys.Area;
import com.dsunsoft.module.admin.entity.sys.AreaTree;
import com.dsunsoft.module.admin.service.sys.AreaService;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, String> implements AreaService {

	// 收缩图标
	private static String FA_FOLDER = "ui-icon-folder";

	// 扩展图标
	private static String FA_FOLDER_OPEN = "ui-icon-folder-open";

	/**
	 * 获取省市区三级联动数据
	 */
	@Override
	public List<NgCascader> getCascaderList() {
		List<NgCascader> list = new ArrayList<>();
		// 获取所有的省市区数据
		List<Area> allList = mapper.getChinaAreaList();
		// 获取省份数据
		List<Area> provinceList = allList.stream().filter(p -> p.getType().equals(AreaType.省份.getValue()))
				.sorted((a, b) -> a.getCode().compareTo(b.getCode())).collect(Collectors.toList());

		for (Area province : provinceList) {
			List<NgCascader> children = new ArrayList<>();
			List<Area> cityList = allList.stream()
					.filter(p -> p.getParentId().equals(province.getId()) && p.getType().equals(AreaType.地市.getValue()))
					.sorted((a, b) -> a.getCode().compareTo(b.getCode())).collect(Collectors.toList());

			for (Area city : cityList) {
				NgCascader second = new NgCascader();
				second.setLabel(city.getName());
				second.setValue(city.getCode());
				List<NgCascader> dList = allList.stream()
						.filter(p -> p.getParentId().equals(city.getId()) && p.getType().equals(AreaType.区县.getValue()))
						.sorted((a, b) -> a.getCode().compareTo(b.getCode())).map(p -> {
							NgCascader t = new NgCascader();
							t.setIsLeaf(true);
							t.setLabel(p.getName());
							t.setValue(p.getCode());
							return t;
						}).collect(Collectors.toList());
				second.setChildren(dList);
				children.add(second);
			}
			NgCascader first = new NgCascader();
			first.setLabel(province.getName());
			first.setValue(province.getCode());
			first.setChildren(children);
			list.add(first);
		}
		return list;
	}

	@Override
	public List<Tree> selectTree(Area area) {
		ArrayList<Tree> listTree = new ArrayList<Tree>();
		List<Area> listAll = mapper.findList(area);
		if (listAll != null && listAll.size() > 0) {
			String areaType = listAll.get(0).getType() != null ? listAll.get(0).getType() : AreaType.国家.getValue();
			List<Area> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
			if (first != null) {
				for (Area menu : first) {
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
	public List<NzTree> selectNzTree(Area area) {
		ArrayList<NzTree> listTree = new ArrayList<NzTree>();
		List<Area> listAll = mapper.findList(area);
		if (listAll != null && listAll.size() > 0) {
			String areaType = listAll.get(0).getType() != null ? listAll.get(0).getType() : AreaType.国家.getValue();
			List<Area> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
			if (first != null) {
				for (Area menu : first) {
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

	private void procTree(List<Area> lst, String id, NzTree tree) {
		List<Area> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
		ArrayList<NzTree> listChildren = new ArrayList<NzTree>();
		if (list != null && list.size() > 0) {
			for (Area area : list) {
				NzTree newTree = new NzTree();
				newTree.setTitle(area.getName());
				newTree.setKey(area.getId());
				newTree.setExpanded(false);
				newTree.setOrigin(area);
				listChildren.add(newTree);
				procTree(lst, area.getId(), newTree);
			}
		} else {
			tree.setIsLeaf(true);
		}
		tree.setChildren(listChildren);
	}

	private void procTree(List<Area> lst, String id, Tree tree) {
		List<Area> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
		ArrayList<Tree> listChildren = new ArrayList<Tree>();
		for (Area area : list) {
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
	public List<AreaTree> selectListTree(Area sysMenu) {
		ArrayList<AreaTree> listTree = new ArrayList<AreaTree>();
		List<Area> listAll = mapper.findList(sysMenu);
		if (listAll != null && listAll.size() > 0) {
			String areaType = listAll.get(0).getType() != null ? listAll.get(0).getType() : AreaType.国家.getValue();
			List<Area> first = listAll.stream().filter(i -> i.getType().equals(areaType)).collect(Collectors.toList());
			if (first != null) {
				for (Area menu : first) {
					AreaTree newTree = new AreaTree();
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

	private void procTree(List<Area> lst, String id, AreaTree tree) {
		List<Area> list = lst.stream().filter(i -> i.getParentId().equals(id)).collect(Collectors.toList());
		ArrayList<AreaTree> listChildren = new ArrayList<AreaTree>();
		for (Area sysMenu : list) {
			AreaTree newTree = new AreaTree();
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

	@Override
	public List<NgSelect> getProvinceList() {
		return mapper.getProvinceList();
	}

	@Override
	public List<NgSelect> getData(AreaSearchDto dto) {
		return mapper.getData(dto);
	}

}
