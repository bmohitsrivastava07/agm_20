package com.ArtGalleryManagement.Backend.Controller;

import com.ArtGalleryManagement.Backend.Entity.*;
import com.ArtGalleryManagement.Backend.RequestModels.*;
import com.ArtGalleryManagement.Backend.Service.*;

/*import com.ArtGalleryManagement.Backend.utils.*;
*/import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/messages")
public class MessagesController {

	private MessagesService messagesService;

	@Autowired
	public MessagesController(MessagesService messagesService) {
		this.messagesService = messagesService;
	}

	@PostMapping("/secure/add/message")
	public void postMessage(@RequestBody Message messageRequest) {
		String userEmail = null;
		messagesService.postMessage(messageRequest, userEmail);
	}

	@PutMapping("/secure/admin/message")
	public void putMessage(@RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
		String userEmail = "admin@gmail.com";
		String admin = "ankita";
		if (admin == null || !admin.equals("admin")) {
			throw new Exception("Administration page only.");
		}
		messagesService.putMessage(adminQuestionRequest, userEmail);
	}

}
