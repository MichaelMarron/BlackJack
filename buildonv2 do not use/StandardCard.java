

import java.util.*;

public class StandardCard implements Card
{

public Rank _rank_;
public Suit _suit_;




    public StandardCard(Rank rank, Suit suit)
    {
        _rank_ = rank;
        _suit_ = suit;
    }


    public Rank getRank(){
        return _rank_;
    }

    public Suit getSuit(){
        return _suit_;
    }

    public String getSuitString()
    {
		return getSuit().getSuitValue();
	}

	public String getRankString()
	{
		return getRank().getRankValue();
	}

}