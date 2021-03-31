package ru.academits.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.academits.dao.ContactDao;

import java.util.Random;

@Component
public class DeleteRandomContactScheduler {
    private final ContactDao contactDao;
    private static final Logger logger = LoggerFactory.getLogger(DeleteRandomContactScheduler.class);

    public DeleteRandomContactScheduler(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Scheduled(fixedRate = 10000)
    public void deleteRandomContact() {
        int count = contactDao.getAllContacts().size();

        if (count > 0) {
            Random random = new Random();

            int index = random.nextInt(count);

            logger.info("called method deleteRandomContact. Delete " + contactDao.getAllContacts().get(index));

            contactDao.getAllContacts().remove(index);

            System.out.println("Scheduler!");
        }
    }
}