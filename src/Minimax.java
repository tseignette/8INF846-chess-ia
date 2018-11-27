public class Minimax
{
    Board state;
    
    public Minimax(Board board_state)
    {
        state = board_state;
    }
    
    public int alphaBetaSearch(state)
    {
        next_move = mmaxValue(Board state, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return next_move;
    }

    public int maxValue(state,alpha,beta)
    {
        int next_move;
        int value = Integer.MIN_VALUE;
        if (vitoryTest(state) == true) 
        {
            return utility(state);
        }
        for (/* Chaque etat successseur*/)
        {
            value = max(value,minValue(/*etat successseur*/, alpha, beta));
            if (value >= beta)
            {
                return value;
            }
            alpha = max(alpha, value);
        }
        return value;
    }
    
    public int minValue(state, alpha, beta)
    {
        if (vitoryTest(state) == true) 
        {
            return utility(state);
        }
        int value = Integer.MAX_VALUE;
        for (/* Chaque etat successseur*/)
        {
            value = min(value,maxValue(/*etat successseur*/, alpha, beta));
            if (value <= alpha)
            {
                return value;
            }
            beta = min(beta, value);
        }
        return value;
    }
    
    public int min(a,b)
    {
        if (a >= b)
        {
            return b;
        }
        else
        {
            return a;
        }
    }
    
    public int max(a,b)
    {
        if (a >= b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

}
