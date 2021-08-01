package com.liger.common.common.mybatis.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class Truncate extends AbstractMethod {

    private static final String SQL_METHOD = "truncate";
    private static final String SQL_STATEMENT = "<script>\nTRUNCATE %s\n</script>";

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        final String sql = String.format(SQL_STATEMENT, tableInfo.getTableName());
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, SQL_METHOD, sqlSource);
    }

}
