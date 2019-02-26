package telran.ashkelon2018.mishpahug.service;

import telran.ashkelon2018.mishpahug.dto.NotificationDto;

public interface NotificationService {
	
//	GET
//	Notifications List
//	Client receives list of his notifications. 
//	The list should be sorted by date in descending order
//	and unread notifications at the top of the list.
//	Клиент получает список своих уведомлений.
//	 Список должен быть отсортирован по дате 
//	в порядке убывания 
//	 и непрочитанных уведомлений вверху списка.
	 
	Iterable<NotificationDto> findNotifications(String token);
	
//	PUT
//	Notification is read
//	User notifies the server that he has read the notification.
//	Пользователь уведомляет сервер о том, что он прочитал уведомление.
	
	boolean notificationIsRead(Long notificationId, String token);
	
//	GET
//	Count unread notifications
//	User receives number of unread notifications.
	
	Integer countUnreadNotifications(String token);
	

	

}
