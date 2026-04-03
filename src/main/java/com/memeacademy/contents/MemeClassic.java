package com.memeacademy.contents;

import com.memeacademy.model.QuizItem;

import java.util.ArrayList;

public class MemeClassic {
    private ArrayList<QuizItem> memesClassic = new ArrayList<>();

    public MemeClassic() {
        this.memesClassic.add(new QuizItem(
                "classicMeme1",
                "<상황>\nA : 여자친구 있어요?\nB : OO OOO\nA : 있었는데?\n",
                new String[]{"아니 그냥 없어요", "아니 없어요"},
                "https://youtu.be/qZtY8Q0AXbQ?si=Up8HCljwo4MYaWjr",
                "ㅇㄴ ㅇㅇㅇ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme2",
                "<시트콤 속 유행어>\n상대방을 미워하거나 얄미워할 때 사용하는 말\n\"야, 이 OOOO야!!!!\"\n",
                new String[]{"죽을래 이 빵꾸똥꾸야", "빵꾸똥꾸", "이 빵꾸똥꾸야"},
                "https://youtube.com/shorts/ECfy7IoK58s?si=VQzdKPKB49vc9zLu",
                "ㅃㄲㄸㄲ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme3",
                "<대화 속 유행어>\nA-이게 뭐에요?\nB-궁금해요? OOOO OOOO\n이 말이 들어갈 말은?\n",
                new String[]{"궁금하면 500원", "궁금하면 오백원"},
                "https://youtube.com/shorts/uk17k1McGC0?si=Gd0sA4cFBBkWidMN",
                "ㄱㄱㅎㅁ ㅇㅂㅇ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme4",
                "<상황>\n예상치 못한 장소나 상황에 아는 사람(혹은 유명인)이 나타났을 때 놀림과 황당함을 표현하는 말\n뜬금없이 반가운 누굴 만났을 때 반가운 기분도 있지만 얼떨떨할 기분으로..! \"OO O OOO OO?\"\n",
                new String[]{"형이 왜 거기서 나와"},
                "https://www.youtube.com/shorts/BD1FOfd-Aag",
                "ㅎㅇ ㅇ ㄱㄱㅅ ㄴㅇ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme5",
                "<상황>\n전혀 예상치 못한 반전이나 놀라운 결과를 접했을 때 사용하는 말\n\"이 볶음밥 재료가 사실은 컵라면?! OOO OO OO\"\n",
                new String[]{"상상도 못한 정체"},
                "https://www.youtube.com/watch?v=Kl-gqgWBtYk",
                "ㅅㅅㄷ ㅁㅎ ㅈㅊ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme6",
                "<상황>\n좌절, 실망, 슬픔의 상황에서 사용되는 말\n\"이번 시험 망쳤네.... 완전 OOO\"\n",
                new String[]{"오티엘", "OTL"},
                "https://namu.wiki/w/OTL",
                "ㅇㅌㅇ"
        ));
        this.memesClassic.add(new QuizItem(
                "classicMeme7",
                "<상황>\n오늘 무대 직캠 진짜 OO..... 저장 안 할 수가 없다....!\n",
                new String[]{"완소"},
                "https://namu.wiki/w/%EC%99%84%EC%86%8C",
                "ㅇㅅ"
        ));
        this.memesClassic.add(new QuizItem(
                "classisMeme8",
                "<상황>\n용례 1: 이번 신메뉴 OOO 맛있음!!\n용례 2: 님 진짜 OOO인듯!\n",
                new String[]{"킹왕짱"},
                "https://namu.wiki/w/%ED%82%B9%EC%99%95%EC%A7%B1",
                "ㅋㅇㅉ"
        ));
        this.memesClassic.add(new QuizItem(
                "classisMeme9",
                "<상황>\n용례 1: 처음 들어보는 이름인데? 완전 OOO이네\n용례 2: 와 진짜 못한다. 저 OOO 선수는 누구냐?\n",
                new String[]{"듣보잡"},
                "https://namu.wiki/w/%EB%93%A3%EB%B3%B4%EC%9E%A1",
                "ㄷㅂㅈ"
        ));
        this.memesClassic.add(new QuizItem(
                "classisMeme10",
                "<상황>\n용례 1: 야 얘 실력이 완전 OOO이네. 못 이기겠다.\n용례 2: 이 영화 관객 수 OOO될 듯\n",
                new String[]{"넘사벽"},
                "https://namu.wiki/w/%EB%84%98%EC%82%AC%EB%B2%BD",
                "ㄴㅅㅂ"
        ));
    }
    public ArrayList<QuizItem> getMemesClassic() {
        return this.memesClassic;
    }

}
