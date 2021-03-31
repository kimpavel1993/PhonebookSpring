package ru.academits;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.academits.dao.ContactDao;
import ru.academits.model.Contact;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PhonebookSpringApplicationTests {
	private final ContactDao contactDao = new ContactDao();

	@Test
	public void testAddContact() {
		Contact testContact = new Contact();

		testContact.setId(1);
		testContact.setFirstName("Петр");
		testContact.setLastName("Петров");
		testContact.setPhone("9123456788");

		contactDao.getAllContacts().add(testContact);

		Assert.assertEquals(2, contactDao.getAllContacts().size());
	}

	@Test
	public void testDeleteContact() {
		contactDao.getAllContacts().remove(0);

		Assert.assertEquals(0, contactDao.getAllContacts().size());
	}
}