package org.hhwy.fweb1.test;

import java.util.List;

import org.hhwy.fweb1.BaseJUnit4TestCase;
import org.hhwy.fweb1.domain.FieldTypes;
import org.hhwy.fweb1.service.FieldTypesService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FieldTypesServiceTest extends BaseJUnit4TestCase {

	@Autowired
	private FieldTypesService service;

	@Test
	public void allServiceTest() {
		int objectCount = this.getRandomInt();
		int deleteCount = 0;
		int updateCount = 0;

		for (int i = 0; i < objectCount; i++) {
			FieldTypes fieldTypes = new FieldTypes();

			fieldTypes.setFieldT01(this.getRandomString());

			fieldTypes.setFieldT02(this.getRandomDouble());

			fieldTypes.setFieldT03(this.getRandomString());

			fieldTypes.setFieldT04(this.getRandomString());

			fieldTypes.setFieldT05(this.getRandomString());
			fieldTypes.setFieldT06(this.getRandomDate());

			fieldTypes.setFieldT07(this.getRandomString());
			fieldTypes.setFieldT08(this.getRandomInt());
			fieldTypes.setFieldT09(this.getRandomInt());

			service.insert(fieldTypes);

			if (this.getRandomBoolean()) {
				service.update(fieldTypes);
				updateCount++;
				continue;
			}

			if (this.getRandomBoolean()) {
				System.out.println("将被删除：" + fieldTypes.getId());
				service.delete(fieldTypes.getId());
				deleteCount++;
				continue;
			}
		}

		System.out.println("写入：" + objectCount + ", 修改：" + updateCount
				+ ", 删除：" + deleteCount + "\n");

		List<FieldTypes> list = service.getAll();
		for (FieldTypes obj : list) {
			System.out.println(obj);
		}

		service.delete(list.get(0).getId());

	}

}
