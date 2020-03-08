package com.stone.hrm.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stone.hrm.pojo.Department;
import com.stone.hrm.pojo.Organization;
import com.stone.hrm.pojo.Permission;

import java.util.List;

/**
 * TreeUtils: 将权限数据生成为一棵树
 *
 * @author Stone
 * @version V1.0
 * @date 2020/1/29
 **/
public class TreeUtils {
    /**
     * 菜单树
     *
     * @param parentId
     * @param permissionsAll
     * @param array
     */
    public static void setPermissionsTree(Integer parentId, List<Permission> permissionsAll, JSONArray array) {
        for (Permission per : permissionsAll) {
            if (per.getParentId().equals(parentId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);
                if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    JSONArray children = new JSONArray();
                    parent.put("children", children);
                    setPermissionsTree(per.getId(), permissionsAll, children);
                }
            }
        }
    }

    /**
     * 组织架构树
     *
     * @param parentId
     * @param organizationsAll
     * @param array
     */
    public static void setOrganizationsTree(Integer parentId, List<Organization> organizationsAll, JSONArray array) {
        for (Organization org : organizationsAll) {
            if (org.getPid().equals(parentId)) {
                String string = JSONObject.toJSONString(org);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);
                if (organizationsAll.stream().filter(o -> o.getPid().equals(org.getId())).findAny() != null) {
                    JSONArray children = new JSONArray();
                    parent.put("children", children);
                    setOrganizationsTree(org.getId(), organizationsAll, children);
                }
            }
        }
    }

    /**
     * 部门架构树
     *
     * @param parentId
     * @param departmentsAll
     * @param array
     */
    public static void setDepartmentsTree(Integer parentId, List<Department> departmentsAll, JSONArray array) {
        for (Department dept : departmentsAll) {
            if (dept.getPid().equals(parentId)) {
                String string = JSONObject.toJSONString(dept);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);
                if (departmentsAll.stream().filter(d -> d.getPid().equals(dept.getId())).findAny() != null) {
                    JSONArray children = new JSONArray();
                    parent.put("children", children);
                    setDepartmentsTree(dept.getId(), departmentsAll, children);
                }
            }
        }
    }
}
