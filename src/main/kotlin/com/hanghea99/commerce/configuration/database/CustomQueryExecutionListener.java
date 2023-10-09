package com.hanghea99.commerce.configuration.database;

import java.util.ArrayList;
import java.util.List;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.proxy.ParameterSetOperation;
import org.springframework.stereotype.Component;

@Component
public class CustomQueryExecutionListener implements QueryExecutionListener {
    @Override
    public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {

    }

    @Override
    public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        System.out.println("==> DataSource Name: "+ execInfo.getDataSourceName());
        for (QueryInfo queryInfo : queryInfoList) {
            System.out.println("==> Preparing: " + queryInfo.getQuery());
            List<String> typeList = new ArrayList<>(queryInfo.getParametersList().size());
            for (List<ParameterSetOperation> parameterSetOperationList : queryInfo.getParametersList()) {
                for (ParameterSetOperation parameterSetOperation : parameterSetOperationList) {
                    if (parameterSetOperation.getArgs()[1] == null) {
                        typeList.add("null");
                    } else {
                        typeList.add(parameterSetOperation.getArgs()[1] + "(" + parameterSetOperation.getArgs()[1].getClass().getSimpleName() + ")");
                    }
                }
            }
            System.out.println("==> Parameters: " + String.join(", ", typeList));
        }
        System.out.println(String.format("<== Elapsed %s ms", execInfo.getElapsedTime()));
    }

}
