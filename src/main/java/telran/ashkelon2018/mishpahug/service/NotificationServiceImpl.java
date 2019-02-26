package telran.ashkelon2018.mishpahug.service;

import telran.ashkelon2018.mishpahug.dto.NotificationDto;

public class NotificationServiceImpl implements NotificationService {

	@Override
	public Iterable<NotificationDto> findNotifications(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean notificationIsRead(Long notificationId, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer countUnreadNotifications(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
