package Assignment1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DBTest {
    private DB db;

    @Before
    public void setUp() {
        db = new DB();
        db.initializeDB();
    }

    @Test
    public void testAddDeck(){
        int deckNum = db.getDeckNum();
        db.addDeck("TestDeck");

        assertEquals("TestDeck", db.getName(deckNum));
        assertEquals(deckNum+1, db.getDeckNum());
    }

    @Test
    public void testAddCard() {
        int indexDeck = db.getDeckNum()-1;

        Card card = new Card("Question", "Answer");

        db.addCard(indexDeck, card);

        assertEquals(card, db.selectCard(indexDeck, db.getDeckSize(indexDeck) - 1));
    }

    @Test
    public void testUpdateCard() {
        int indexDeck = db.getDeckNum()-1;
        int cardDeck = 0;
        Card card = new Card("Question", "Answer");

        db.addCard(indexDeck, card);
        String newQuestion = "New Question";
        String newAnswer = "New Answer";

        db.updateCard(indexDeck, cardDeck, newQuestion, newAnswer);

        assertEquals(newQuestion, db.selectCard(indexDeck, cardDeck).getQuestion());
        assertEquals(newAnswer, db.selectCard(indexDeck, cardDeck).getAnswer());
    }

    @Test
    public void testDeleteCard() {
        int indexDeck = db.getDeckNum()-1;
        
        Card card = new Card("Question", "Answer");

        db.addCard(indexDeck, card);

        int initialSize = db.getDeckSize(indexDeck);

        db.deleteCard(indexDeck, 0);

        assertEquals(initialSize - 1, db.getDeckSize(indexDeck));
    }

    @Test
    public void testDeleteDeck(){
        int deckNum = db.getDeckNum();

        db.deleteDeck(deckNum-1);

        assertEquals(deckNum-1, db.getDeckNum());
    }
}
