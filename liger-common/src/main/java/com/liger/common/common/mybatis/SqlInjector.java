package com.liger.common.common.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.liger.common.common.mybatis.method.*;

import java.util.List;

public class SqlInjector extends DefaultSqlInjector {

    /**
     * 如果只需增加方法，保留MP自带方法
     * 可以super.getMethodList() 再add
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new BatchInsert());
        methodList.add(new Replace());
        methodList.add(new BatchReplace());
        methodList.add(new DeleteAll());
        methodList.add(new Truncate());
        return methodList;
    }

}