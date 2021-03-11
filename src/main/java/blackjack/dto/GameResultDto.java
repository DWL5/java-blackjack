package blackjack.dto;

import java.util.List;

public class GameResultDto {
    WinPrizeDto dealerWinPrize;
    List<WinPrizeDto> playersWinPrize;

    public GameResultDto(WinPrizeDto winPrizeDto, List<WinPrizeDto> playersWinPrize) {
        this.dealerWinPrize = winPrizeDto;
        this.playersWinPrize = playersWinPrize;
    }

    public WinPrizeDto getDealerWinPrize() {
        return dealerWinPrize;
    }

    public List<WinPrizeDto> getPlayersWinPrize() {
        return playersWinPrize;
    }
}
