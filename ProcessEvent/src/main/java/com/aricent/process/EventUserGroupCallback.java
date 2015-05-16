
package com.aricent.process;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import org.kie.api.task.UserGroupCallback;


@Alternative
public class EventUserGroupCallback implements UserGroupCallback {

    public boolean existsUser(String userId) {
        return true;
    }

    public boolean existsGroup(String groupId) {
        return true;
    }

    public List<String> getGroupsForUser(String userId,
            List<String> groupIds, List<String> allExistingGroupIds) {
    
        return new ArrayList<String>();
    }
}
