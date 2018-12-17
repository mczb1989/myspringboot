package com.zb.service.impl;

import com.zb.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhangbin on 2018/8/17.
 */
@Service
public class SolrServiceImpl implements SolrService {
    @Autowired
    private SolrClient solrClient;

    @Override
    public void create() {
        //创建索引
        SolrInputDocument solrInputDocument=new SolrInputDocument();
        solrInputDocument.addField("id", "1");
        solrInputDocument.addField("username", "admin");
        solrInputDocument.addField("password", "22222");
        try {
            solrClient.add(solrInputDocument);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void query() {
        //查询第一种方式
        ModifiableSolrParams params =new ModifiableSolrParams();
        params.add("q","username:admin");
        params.add("ws","json");
        params.add("start","0");
        params.add("rows","10");
        QueryResponse queryResponse= null;
        try {
            queryResponse = solrClient.query(params);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(queryResponse);

    }

    @Override
    public void delete() {
        try {
//            solrClient.deleteById("1");
            solrClient.deleteByQuery("admin");
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
