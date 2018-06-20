package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.List;

/*
*类名和方法不能修改
 */
public class Schedule {
    
    private TaskInfo taskInfo=new TaskInfo();


    public int init() {
        
        unregisterNode(taskInfo.getNodeId());
        
        deleteTask(taskInfo.getTaskId());
        
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if (nodeId<=0)
        {
            return ReturnCodeKeys.E004;
        }
        
        if (nodeId==taskInfo.getNodeId())
        {
            return ReturnCodeKeys.E005;
        }
        taskInfo.setNodeId(nodeId);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {
        if (nodeId<=0)
        {
            return ReturnCodeKeys.E004;
        }
        if (nodeId!=taskInfo.getNodeId())
        {
            return ReturnCodeKeys.E007;
        }
        taskInfo.setNodeId(0);
        return ReturnCodeKeys.E006;
    }


    public int addTask(int taskId, int consumption) {
        if (taskId<=0)
        {
            return ReturnCodeKeys.E009;
        }
        if (taskId==taskInfo.getTaskId())
        {
            return ReturnCodeKeys.E010;
        }
        taskInfo.setTaskId(taskId);
        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        if (taskId<=0)
        {
            return ReturnCodeKeys.E009;
        }
        if (taskId!=taskInfo.getTaskId())
        {
            return ReturnCodeKeys.E012;
        }
        taskInfo.setTaskId(0);
        return ReturnCodeKeys.E011;
    }


    public int scheduleTask(int threshold) {
        if (threshold <=0)
        {
            return ReturnCodeKeys.E002;  
        }
        return ReturnCodeKeys.E013;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        if (tasks.equals(null))
        {
            return ReturnCodeKeys.E016;
        }
        return ReturnCodeKeys.E015;
    }

}
