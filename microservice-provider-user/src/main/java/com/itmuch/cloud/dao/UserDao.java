/*
 * 文件名：UserDao.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserDao.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月6日
 * 修改内容：新增
 */
package com.itmuch.cloud.dao;
/**
 * @Title:  UserDao.java
 * @Package: com.itmuch.cloud.dao.UserDao.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月6日 下午3:23:26
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
