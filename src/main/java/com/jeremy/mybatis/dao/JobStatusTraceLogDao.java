/**
 * 
 */
package com.jeremy.mybatis.dao;

import com.jeremy.mybatis.model.JobStatusTraceLog;

/**
 * @author jeremy
 *
 */
public interface JobStatusTraceLogDao {

	JobStatusTraceLog selectById(String id);
}
