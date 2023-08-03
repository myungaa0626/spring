package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sqlSessionFactory = null;

	static {

		try {
			if (sqlSessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml"); // mapper file path
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	} // static end

	public static SqlSession getSqlSessionInstance() {

		return sqlSessionFactory.openSession(true);

	}

}
