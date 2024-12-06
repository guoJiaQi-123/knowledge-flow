package com.tyut.readwritelock;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote TODO(一句话给出该类描述)
 */
public class GenericDao {
    public int update(String sql, Object[] params) {
        return 1;
    }

    public <T> T queryOne(Class<T> beanClass, String sql, Object[] params) {
        return null;
    }
}
