package com.zb.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {
    @Test
    public void test1(){
        //1.创建一个流程引擎配置对象
        String resource= "activiti.cfg.xml";
        String beanName="processEngineConfiguration";
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(resource,beanName);

        //创建一个流程引擎对象，在创建流程引擎对象时会自动建表
        ProcessEngine engine= configuration.buildProcessEngine();
    }

    /**
     * 部署流程定义(操作数据表：act_re_deployment、act_re_procdef、act_ge_bytearray)
     */
    @Test
    public void test4() {
        // 获得一个部署构建器对象，用于加载流程定义文件（test1.bpmn,test.png）完成流程定义的部署
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        DeploymentBuilder builder= processEngine.getRepositoryService().createDeployment();
        // 加载流程定义文件
        builder.addClasspathResource("activiti/FirstDiagram.bpmn");
        builder.addClasspathResource("activiti/FirstDiagram.png");
        // 部署流程定义
        Deployment deployment = builder.deploy();
        System.out.println(deployment.getId());
    }

    //2. 启动流程
    @Test
    public void startProcess() throws Exception {
        // 获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 启动流程
        //使用流程定义的key启动流程实例，默认会按照最新版本启动流程实例
        ProcessInstance pi = processEngine.getRuntimeService()
                .startProcessInstanceByKey("myProcess");
        System.out.println("pid:" + pi.getId() +",activitiId:" + pi.getActivityId());
    }

    //3. 查看任务
    @Test
    public void queryMyTask() throws Exception {
        // 指定任务办理者
        String assignee = "张三";
        // 获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 查询任务的列表
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()//创建任务查询对象
                .taskAssignee(assignee)//指定个人任务办理人
                .list();
        // 遍历结合查看内容
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId()+",taskName:" + task.getName());
            System.out.println("*************************");
        }
    }

    //4. 办理任务
    @Test
    public void completeTask() throws Exception {
        String taskId = "2504";
        // 获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 完成任务
        processEngine.getTaskService()
                .complete(taskId);
        System.out.println("完成任务！");
    }


    @Test
//    @Ignore
    public void testdeployAqs(){
//        String name = ActFlowType.Aqs.getName(); //流程名
//        String category = ActFlowType.Aqs.getCode(); //流程区分code
//        String tenantid = ActFlowType.Aqs.getCode()+"_"+"{projectId}";
//        String classpath = "com/caa/aqs/service/api/activiti/aqs.bpmn";
        String name = "测试流程"; //流程名
        String category = "ceshi"; //流程区分code
        String tenantid = "ceshi_453";
        String classpath = "activiti/leave.bpmn";

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService  repositoryService = processEngine.getRepositoryService();

        try {
            Deployment deployment = repositoryService.createDeployment().name(name).category(category).tenantId(tenantid).addClasspathResource(classpath).deploy();

            System.out.println(deployment.getId());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }



}
