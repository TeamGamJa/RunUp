package team.spring.runup.message.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import team.spring.runup.message.dao.MessageDaoImpl;
import team.spring.runup.message.vo.Message;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	// �α� �߰�
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	MessageDaoImpl dao;
	
//	private final PlatformTransactionManager transactionManager;
	
	
//	public MessageServiceImpl(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	
	// ���� ����(����)
	public int sendMessage(Message message) {
		int result = 0;
//			TransactionStatus txStatus =
//					transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			result = dao.create(message);
			if (result == 1) {
//				transactionManager.commit(txStatus);
				log.debug("service => �߽���Ǿ����");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
//			transactionManager.rollback(txStatus);
			log.debug("service => ���� �̻��ؿ� ����={}", e);
			throw new RuntimeException("���� ���� �� ������ �߻��߽��ϴ�.", e);
		}
		return result;
	}

}
