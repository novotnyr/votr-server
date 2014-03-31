import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/votr/votes")
public class Endpoint {
	private AtomicInteger yesVotes = new AtomicInteger(0);
	
	private AtomicInteger noVotes = new AtomicInteger(0);

	@RequestMapping(value = "/{id}")
	public String getVoteByIdAsHtml(@PathVariable String id) {
		String yeahDiv = "<div style='width:" 
				+ yesVotes.get() * 30
				+ "px; background: red; font-size: 2em'>YES" + yesVotes.get()
				+ "</div>";
		String nayDiv = "<div style='width:" 
				+ noVotes.get() * 30
				+ "px; background: green; font-size: 2em'>NO" + noVotes.get()
				+ "</div>";
		return "<div style='width: 2000px;'>" + yeahDiv + "\n" + nayDiv
				+ "</div>";
	}
	
	
    @RequestMapping(value = "/{id}", params = "json")
    public Vote getVoteById(@PathVariable String id) {
      	Vote vote = new Vote();
    	vote.setName("Androidy zadarmo");
    	vote.setDescription("Súhlasíte s tým, aby každý člen kurzu dostal telefón s Androidom zadarmo?");
    	vote.setDeadline(new Date(115, 11, 10));
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		return vote;
    }
    
    @RequestMapping(method=POST)
    public void submitVote(@RequestBody String vote) {
    	if("yes".equalsIgnoreCase(vote)) {
    		yesVotes.incrementAndGet();
    	}
    	if("no".equalsIgnoreCase(vote)) {
    		noVotes.incrementAndGet();
    	}    	
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Endpoint.class, args);
    }

}