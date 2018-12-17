package com.zb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangbin on 2018/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrServiceTest {
    @Autowired
    private SolrService solrService;

    @Test
    public void testCreate(){
        solrService.create();
    }

    @Test
    public void testQuery(){
        solrService.query();
    }

    @Test
    public void testDelete(){
        solrService.delete();
    }
}
