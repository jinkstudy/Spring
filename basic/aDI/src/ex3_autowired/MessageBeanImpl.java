package ex3_autowired;

import java.io.IOException;

import javax.annotation.Resource;

public class MessageBeanImpl implements MessageBean  {
		// 값지정 - 생성자 or setter
		private String name;
		private String message;
		
		// 값지정 - 생성자 or setter or @annotation
		//@Autowired 
		//@Qualifier("outputer2")
		
		@Resource(name="outputer")
		private Outputer out;
		

		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getMessage() {
			return message;
		}



		public void setMessage(String message) {
			this.message = message;
		}
		

		public void sayHello() {
			System.out.println(name+"님께"+message);
			try {
				out.writeMessage(name+"님께"+message);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

}
