package com.liger.common.common.mybatis.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class BatchReplace extends AbstractMethod {

    private static final String SQL_METHOD = "batchReplace";
    private static final String SQL_STATEMENT = "<script>REPLACE INTO %s %s VALUES %s</script>";

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        final String fieldSql = BatchInsert.prepareFieldSql(tableInfo);
        final String valueSql = BatchInsert.prepareValuesSqlForMysqlBatch(tableInfo);
        final String sql = String.format(SQL_STATEMENT, tableInfo.getTableName(), fieldSql, valueSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addInsertMappedStatement(mapperClass, modelClass, SQL_METHOD, sqlSource, new NoKeyGenerator(), null, null);
    }

}