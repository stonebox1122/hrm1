package com.stone.hrm.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
}
