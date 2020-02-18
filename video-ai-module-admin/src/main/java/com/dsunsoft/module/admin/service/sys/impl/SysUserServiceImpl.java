package com.dsunsoft.module.admin.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dsunsoft.common.constant.WebConstants;
import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.common.util.DigestUtils;
import com.dsunsoft.common.util.EncodeUtils;
import com.dsunsoft.common.util.IdWorker;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.core.util.Digests;
import com.dsunsoft.core.util.Encodes;
import com.dsunsoft.module.admin.dao.sys.SysRoleMapper;
import com.dsunsoft.module.admin.dao.sys.SysUserMapper;
import com.dsunsoft.module.admin.entity.sys.Menu;
import com.dsunsoft.module.admin.entity.sys.SysNgalainMenuTree;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysUser;
import com.dsunsoft.module.admin.entity.sys.SysUserRole;
import com.dsunsoft.module.admin.service.sys.SysUserService;
import com.google.common.collect.Lists;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser, String> implements SysUserService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    
    
	@Autowired
	private SysRoleMapper roleMapper;

	public SysUser getByName(String userName) {
		return mapper.getByName(userName);
	}
	
	public Boolean checkLoginName(String oldLoginName, String loginName) {
        if (loginName !=null && loginName.equals(oldLoginName)) {
            return true;
        } else if (loginName !=null && mapper.getByName(loginName) == null) {
            return true;
        }
        return false;
    }

	public SysUser getUserMenu(String userId) {
		SysUser user = mapper.getById(userId);
		// 获取角色
		List<SysRole> roleList = mapper.getRoleByUserId(userId);
		if (roleList != null && roleList.size() > 0) {
			// 加载菜单数据
			List<String> listRoleId = roleList.stream().map(SysRole::getRoleId).collect(Collectors.toList());
			List<String> listRoleName = roleList.stream().map(SysRole::getRoleName).collect(Collectors.toList());
			user.setRoleName(String.join(",", listRoleName));
			user.setRoleIds(listRoleId);
			user.setRoles(roleList);
			List<Menu> muenList = roleMapper.getMenuByRoleId(listRoleId);
			if (muenList != null) {
				Map<String, SysNgalainMenuTree> parentTreeKey = new HashMap<String, SysNgalainMenuTree>();
				ArrayList<SysNgalainMenuTree> treeList = new ArrayList<SysNgalainMenuTree>();
				List<Object> menuJsonList = new ArrayList<Object>();
				for (Menu menu : muenList) {
					Map<String, String> menuMap = new HashMap<>();
					menuMap.put("menu." + menu.getMenuId(), menu.getMenuName());
					menuJsonList.add(menuMap);
					SysNgalainMenuTree tree = getNgAlainTree(menu);
					SysNgalainMenuTree parentTree = (SysNgalainMenuTree) parentTreeKey.get(menu.getPid());
					if (parentTree == null) {
						addTreeToList(treeList, tree);
						parentTreeKey.put(tree.getMenuId(), tree);
					} else {
						if (parentTree.getChildren() == null) {
							ArrayList<SysNgalainMenuTree> items = new ArrayList<SysNgalainMenuTree>();
							items.add(tree);
							parentTree.setChildren(items);
						} else {
							parentTree.getChildren().add(tree);
						}
						parentTreeKey.put(tree.getMenuId(), tree);
					}
				}
				//userAccount.setMenuJsonList(menuJsonList);
				SysNgalainMenuTree rootTree = new SysNgalainMenuTree();
				rootTree.setText("主导航");
				rootTree.setI18n("menu.main");
				rootTree.setGroup(false);
				rootTree.setHideInBreadcrumb(true);
				rootTree.setLink("/dashboard/workplace");
				rootTree.setChildren(treeList);
				rootTree.setIcon("anticon anticon-dashboard");
				ArrayList<SysNgalainMenuTree> rootTreeList = new ArrayList<SysNgalainMenuTree>();
				rootTreeList.add(rootTree);
				user.setMenuTreeList(rootTreeList);
				user.setAllMenuList(muenList);
			}
		}
		return user;
	}

	private void addTreeToList(ArrayList<SysNgalainMenuTree> treeList, SysNgalainMenuTree tree) {
		boolean isHave = false;
		for (SysNgalainMenuTree t : treeList) {
			if (t.getMenuId().equals(tree.getMenuId())) {
				isHave = true;
			}
		}
		if (!isHave) {
			treeList.add(tree);
		}
	}

	private SysNgalainMenuTree getNgAlainTree(Menu detail) {
		SysNgalainMenuTree tree = new SysNgalainMenuTree();
		tree.setText(detail.getMenuName());
		//tree.setI18n("menu." + detail.getMenuId());
		tree.setIcon(detail.getIcon());
		tree.setMenuId(detail.getMenuId());
		tree.setLink(detail.getPath());
		return tree;
	}

	@Override
	public Boolean updateRole(SysUser arg0) {
		return null;
	}

	@Override
	public SysUser loadRoles(SysUser sysUser) {
		// 获取所有的角色
		List<SysRole> listAllRole = roleMapper.findList(null);
		listAllRole = listAllRole.stream().filter(i -> !i.getRoleId().equals(WebConstants.ROLE_SUPER_ADMIN))
				.collect(Collectors.toList());
		sysUser.setRoles(listAllRole);
		return sysUser;
	}

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public String entryptPassword(String plainPassword) {
		byte[] salt = DigestUtils.generateSalt(SALT_SIZE);
		byte[] hashPassword = DigestUtils.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return EncodeUtils.encodeHex(salt) + EncodeUtils.encodeHex(hashPassword);
	}
	
	/**
     * 验证密码
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @return 验证成功返回true
     */
    public boolean validatePassword(String plainPassword, String password) {
        byte[] salt = Encodes.decodeHex(password.substring(0,16));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

	@Override
	public List<SysRole> getRoleByUserId(String userId) {
		return mapper.getRoleByUserId(userId);
	}
	
	/**
	 * 设置用户的角色
	 * @param sysUser
	 */
	public void setUserRole(SysUser sysUser){
	    // 角色数据有效性验证，过滤不在授权内的角色
        List<SysUserRole> roleList = Lists.newArrayList();
        List<String> roleIds = sysUser.getRoleIds();
        for (String roleId : roleIds){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(sysUser.getId());
            sysUserRole.setUserRoleId(IdWorker.getUuid());
            roleList.add(sysUserRole);
        }
        sysUser.setRoleList(roleList);
	}

	@Transactional
    @Override
    public Boolean save(SysUser sysUser) throws BizException {
        int result = 0;
        // TODO Auto-generated method stub
        if (!StringUtils.hasText(sysUser.getId())){
            sysUser.setId(IdWorker.getUuid());
            //设置用户角色
            this.setUserRole(sysUser);
            int ins = mapper.insert(sysUser);
            //设置角色
            int inrs = 0;
            if (sysUser.getRoleList() != null && sysUser.getRoleList().size() > 0){
                inrs =  mapper.insertUserRole(sysUser);
            }
            else {
                throw new BizException(sysUser.getLoginName() + "没有设置角色！");
            }
            result +=(ins + inrs);
        }
        else {
            //设置用户角色
            this.setUserRole(sysUser);
            int ins = mapper.update(sysUser);
            // 更新用户与角色关联
            int inds = mapper.deleteUserRole(sysUser);
            int inrs = 0;
            if (sysUser.getRoleList() != null && sysUser.getRoleList().size() > 0){
                inrs =  mapper.insertUserRole(sysUser);
            }
            else {
                throw new BizException(sysUser.getLoginName() + "没有设置角色！");
            }
            result +=(ins + inds + inrs);
        }
        return result>0;
    }

	@Override
	public List<NgSelect> getSelectByNonAdmin() {
		return mapper.getSelectByNonAdmin();
	}

}
