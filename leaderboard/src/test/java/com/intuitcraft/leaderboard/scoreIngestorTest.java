package com.intuitcraft.leaderboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intuitcraft.leaderboard.entity.playerScore;
import com.intuitcraft.leaderboard.exceptions.LeaderboardNotInitialized;
import com.intuitcraft.leaderboard.repository.playerScoreRepository;
import com.intuitcraft.leaderboard.services.leaderBoardService;
import com.intuitcraft.leaderboard.services.scoreIngestionServiceImpl;

@SpringBootTest(classes = LeaderboardApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class scoreIngestorTest {
	@Autowired
	leaderBoardService leaderBoard;
	@Autowired
	scoreIngestionServiceImpl scoreIngestor;
	@Autowired
	playerScoreRepository scoreRepository;
	
	@Test
	public void test() {
		try {
			/*scoreIngestor.publish(new playerScore("OP", 700));
			for (playerScore p : leaderBoard.getTopNPlayers())
				System.out.println(p);*/
			leaderBoard.createBoard(3);
			scoreIngestor.publish(new playerScore("OP", 600));
			scoreIngestor.publish(new playerScore("GB", 700));
		
			for (playerScore p : leaderBoard.getTopNPlayers())
				System.out.println(p);
		} catch (LeaderboardNotInitialized e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
