package com.memeacademy.app;

import com.memeacademy.constant.MemeCategory;
import com.memeacademy.model.QuizBank;
import com.memeacademy.model.QuizItem;
import com.memeacademy.model.User;
import com.memeacademy.model.UserService;

import java.util.*;

public class MemeAcademyMain {
    public static String getRandomMessage(String[] messages) {
        return messages[RANDOM.nextInt(messages.length)];
    }
    private static final String[] CORRECT_MESSAGES = {
            "정답입니다! 좀 치는데?",
            "와 이걸 맞추네ㅋㅋ 인정",
            "밈 박사 후보생 등장",
            "감 좋다… 인정한다",
            "이건 솔직히 잘했다",
            "알잘딱깔센 인정 👍"
    };

    private static final String[] WRONG_MESSAGES = {
            "헛소리하지마 인마!",
            "이걸 틀리네ㅋㅋ",
            "밈 압수합니다",
            "인터넷 끊겼냐?",
            "이건 좀 킹받네",
            "다시 태어나자"
    };

    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = false;
        UserService userService = new UserService();

        while (!isQuit) {
            showIntroScreen();
            int userInput = readMenu(scanner);
            scanner.nextLine();
            isQuit = handleIntroMenu(userInput, userService, scanner);
        }

        scanner.close();
    }

    public static void showIntroScreen() {
        System.out.println();
        System.out.println("================================================");
        System.out.println("                MEME ACADEMY JAVA");
        System.out.println("================================================");
        System.out.println("          밈 박사 양성기관에 오신 것을 환영합니다");
        System.out.println("          \"이 밈을 모른다고? 지금부터 외우면 됨\"");
        System.out.println();

        System.out.println("   ███    ███ ███████ ███    ███ ███████");
        System.out.println("   ████  ████ ██      ████  ████ ██");
        System.out.println("   ██ ████ ██ █████   ██ ████ ██ █████");
        System.out.println("   ██  ██  ██ ██      ██  ██  ██ ██");
        System.out.println("   ██      ██ ███████ ██      ██ ███████");
        System.out.println();

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                밈 박사 입학 안내서                        ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  · 당신의 밈 이해력을 측정합니다.                           ║");
        System.out.println("║  · 문제를 보고 정답을 입력하세요.                           ║");
        System.out.println("║  · 모르면 찍지 말고 감으로 버텨도 됩니다.                     ║");
        System.out.println("║  · 틀리면 살짝 킹받을 수 있습니다.                           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                    메인 메뉴판                          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║   [1] 입학하기                                         ║");
        System.out.println("║   [2] 설명 보기                                        ║");
        System.out.println("║   [3] 억울함 제보                                       ║");
        System.out.println("║   [4] 랭킹 보기                                         ║");
        System.out.println("║   [5] 나가기                                           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("> 상태 : 드립 수신 감도 최대치");
        System.out.println("> 상태 : 킹받음 내성 로딩 중");
        System.out.println("> 상태 : 밈 박사 코스 준비 완료");
        System.out.println("> 상태 : 오늘도 알잘딱깔센하게 맞혀보자");
        System.out.println();
    }

    public static int readMenu(Scanner scanner) {
        System.out.print("선택 > ");
        return scanner.nextInt();
    }

    public static boolean handleIntroMenu(int userInput, UserService userService, Scanner scanner) {
        switch (userInput) {
            case 1:
                System.out.println();
                System.out.println("[입학하기]");
                System.out.println("닉네임과 밈 코스를 선택하는 화면으로 이동합니다.");
                User user = createUser(scanner);
                showUserStartScreen(user, userService, scanner);
                break;

            case 2:
                showGameGuide(scanner);
                break;

            case 3:
                showReportMessage(scanner);
                break;

            case 4:
                showAllScore(userService.getUsers(), scanner);
                break;
            case 5:
                System.out.println();
                System.out.println("밈 박사 코스 졸업 유예.....");
                return true;

            default:
                System.out.println();
                System.out.println("올바른 메뉴 번호를 입력해주세요.");
                System.out.println();
                break;
        }

        return false;
    }

    public static User createUser(Scanner scanner) {
        System.out.println();
        System.out.println("================================================");
        System.out.println("                  입학 신청서");
        System.out.println("================================================");

        String nickname = inputUserName(scanner);
        String category = inputMemeCategory(scanner);

        return new User(nickname, category);
    }

    public static String inputUserName(Scanner scanner) {
        System.out.print("유저 이름을 입력하세요 > ");
        String userName = scanner.nextLine();

        while(userName.length() < 2 || userName.length() > 12) {

            if (userName.isEmpty()) {
                System.out.println("유저 이름은 공백으로 둘 수 없습니다.");
            }
            if (!userName.isEmpty() && (userName.length() < 2 || userName.length() > 12)) {
                System.out.println("유저 이름은 2자 이상 12자 이하로 입력되어야 합니다.");
            }
            System.out.println();
            System.out.print("유저 이름을 입력하세요 > ");
            userName = scanner.nextLine().trim();
        }
        System.out.println("정상적으로 입력되었습니다.");

        return userName;
    }

    public static String inputMemeCategory(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("┌────────────────────────────────────────────┐");
            System.out.println("│            수강할 밈 코스를 선택하세요            │");
            System.out.println("├────────────────────────────────────────────┤");
            System.out.println("│ 1. 2025년 밈                                │");
            System.out.println("│ 2. 2024년 밈                                │");
            System.out.println("│ 3. 고전 밈                                   │");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.print("선택 > ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    return MemeCategory.MEME_2025;
                case "2":
                    return MemeCategory.MEME_2024;
                case "3":
                    return MemeCategory.MEME_CLASSIC;
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    public static void startQuiz(User user, UserService userService, ArrayList<QuizItem> quizList, Scanner scanner) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("퀴즈를 시작합니다.");
        System.out.println("플레이어 : " + user.getUserName());
        System.out.println("카테고리 : " + user.getMemeCategory());
        System.out.println("========================================");

        int questionNumber = 1;

        for (QuizItem quizItem : quizList) {
            System.out.println();
            System.out.println("[" + questionNumber + "번 문제]");
            System.out.println(quizItem.getQuestion());
            System.out.print("정답 입력 > ");

            String input = scanner.nextLine().trim();

            if (isCorrectAnswer(input, quizItem.getEnableAnswer())) {
                System.out.println("\n" + getRandomMessage(CORRECT_MESSAGES));
                user.setOneTryScore();
                user.addSolvedQuiz(quizItem);
            } else {
                System.out.println("\n" + getRandomMessage(WRONG_MESSAGES));1
                System.out.println("힌트(초성) : " + quizItem.getHint());

                System.out.print("\n정답 입력 > ");
                String retryInput = scanner.nextLine().trim();

                if (isCorrectAnswer(retryInput, quizItem.getEnableAnswer())) {
                    System.out.println("\n정답입니다!");
                    System.out.println("풋 힌트를 보고 맞추다니 ㅎㅎ 5점만 드림.");
                    user.addSolvedQuiz(quizItem);
                    user.setTwoTryScore();
                } else {
                    System.out.println("\n이걸 몰라?? 넌 안되겠다!");
                    System.out.println("정답 : " + quizItem.getEnableAnswer()[0]);
                }
            }

            System.out.println("현재 점수 : " + user.getScore());
            questionNumber++;
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("퀴즈 종료");
        System.out.println("플레이어 : " + user.getUserName());
        System.out.println("최종 점수 : " + user.getScore());
        System.out.println("========================================");

        userService.addUser(user);
        showScore(userService.getUsers(), user.getMemeCategory());

        System.out.print("당신의 밈 실력 : ");
        if (user.getScore() <= 100) {
            System.out.println("당신을 밈 지박령으로 임명합니다.");
        } else if (user.getScore() < 80) {
            System.out.println("당신 꽤나 MZ?");
        } else if (user.getScore() < 60) {
            System.out.println("당신은 M도 Z도 아닌 그 무언가…");
        } else if (user.getScore() < 40) {
            System.out.println("밈 사망선고 내리겠습니다 삐———-");
        } else if (user.getScore() < 20) {
            System.out.println("아재시군요…. 아자스!!");
        }

        System.out.print("\n<<틀린 문제 보러 가기>>\n\n보러 가고 싶다면 1 누르고, 처음으로 돌아가려면 0 눌러!! > ");
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            showUnCorrectQuiz(user.getSolvedQuizList(), quizList);
            System.out.print("아무 키나 입력 후 엔터(빈 값은 안돼요!!) > ");
            scanner.next();
            System.out.println();
        }
    }

    public static void showUnCorrectQuiz(ArrayList<QuizItem> userSolvedQuizList, ArrayList<QuizItem> quizList) {
        System.out.println();
        System.out.println("================================================");
        System.out.println("                 밈 퀴즈 채점표");
        System.out.println("================================================");

        int correctCount = 0;
        for (QuizItem quizItem : quizList) {
            if (userSolvedQuizList.contains(quizItem)) {
                correctCount++;
            }
        }

        System.out.printf("총 문제 수    : %d%n", quizList.size());
        System.out.printf("맞은 문제 수  : %d%n", correctCount);
        System.out.printf("틀린 문제 수  : %d%n", quizList.size() - correctCount);
        System.out.println("================================================");
        System.out.println();

        int index = 1;

        for (QuizItem quizItem : quizList) {
            boolean isCorrect = userSolvedQuizList.contains(quizItem);

            System.out.println("------------------------------------------------");
            System.out.printf("[%d번 문제]%n", index);
            System.out.printf("\n%s%n", quizItem.getQuestion());
            System.out.printf("%-10s : %s%n", "정답", quizItem.getEnableAnswer()[0]);
            System.out.printf("%-10s : %s%n", "결과", isCorrect ? "정답" : "오답");

            if (!isCorrect) {
                System.out.printf("%-9s : %s%n", "복습 영상", quizItem.getOriginUrl());
            }

            System.out.println("------------------------------------------------");
            System.out.println();

            index++;
        }
    }

    public static void showAllScore(ArrayList<User> users, Scanner scanner) {
        showScore(users, MemeCategory.MEME_2024);
        showScore(users, MemeCategory.MEME_2025);
        showScore(users, MemeCategory.MEME_CLASSIC);
        System.out.print("아무 키나 입력 후 엔터(빈 값은 안돼요!!) > ");
        scanner.next();
        System.out.println();
    }

    public static void showScore(ArrayList<User> users, String memeCategory) {
        System.out.println();
        System.out.println("================================================");
        System.out.println("                     밈 랭킹");
        System.out.println("================================================");
        System.out.println("코스   : " + memeCategory);
        System.out.println();

        List<User> filteredUsers = users.stream()
                .filter(item -> item.getMemeCategory().equals(memeCategory)).sorted(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o2.getScore() - o1.getScore();
                    }
                }).toList();

        if (filteredUsers.isEmpty()) {
            System.out.println("아직 해당 코스의 랭킹 데이터가 없습니다.");
            System.out.println();
            return;
        }

        System.out.println("-----------------------------------------------");
        System.out.printf("%-11s %-15s %-10s%n", "순위", "닉네임", "점수");
        System.out.println("-----------------------------------------------");

        int ranking = 1;

        for (User user : filteredUsers) {
            System.out.printf("%-12d %-15s %-20d%n",
                    ranking,
                    user.getUserName(),
                    user.getScore());
            ranking++;
        }

        System.out.println("-----------------------------------------------");
        System.out.println();
    }

    public static void showUserStartScreen(User user, UserService userService, Scanner scanner) {
        System.out.println();
        System.out.println("================================================");
        System.out.println("                 입학 완료");
        System.out.println("================================================");
        System.out.println("닉네임      : " + user.getUserName());
        System.out.println("선택 코스   : " + user.getMemeCategory());
        System.out.println();
        System.out.println(user.getUserName() + "님 밈 박사 입학을 축하합니다.");
        System.out.println("이제부터 당신의 밈력을 파악하겠습니다....... 두구두구두구");
        System.out.println();
        System.out.println("1. 퀴즈 시작");
        System.out.println("2. 메인 화면으로 돌아가기");
        System.out.print("선택 > ");

        String input = scanner.nextLine().trim();

        QuizBank quizBank = new QuizBank();
        ArrayList<QuizItem> currentQuizList = quizBank.getQuizListByCategory(user.getMemeCategory());

        if ("1".equals(input)) {
            startQuiz(user, userService, currentQuizList, scanner);
        } else {
            System.out.println("메인 화면으로 돌아갑니다.");
            System.out.println();
        }
    }

    public static boolean isCorrectAnswer(String input, String[] answers) {
        for (String answer : answers) {
            if (answer.equalsIgnoreCase(input.trim())) {
                return true;
            }
        }
        return false;
    }

    public static void showGameGuide(Scanner scanner) {
        System.out.println();
        System.out.println("[게임 설명]");
        System.out.println("- 닉네임을 입력하고 밈 카테고리를 선택합니다.");
        System.out.println("- 문제를 보고 정답을 입력하면 됩니다.");
        System.out.println("- 정답을 맞히면 점수가 올라갑니다.");
        System.out.println("- 틀리면 힌트가 나올 수도 있습니다.");
        System.out.println();
        System.out.print("아무 키나 입력 후 엔터(빈 값은 안돼요!!) > ");
        scanner.next();
        System.out.println();
    }

    public static void showReportMessage(Scanner scanner) {
        System.out.println();
        System.out.println("[억울함 제보]");
        System.out.println("제작자에게 하고 싶은 말을 남겨주세요.");
        System.out.println("--> 물론 듣기만 하겠습니다..!");
        System.out.print("마음속으로 말한 후 아무 키나 입력 후 엔터(빈 값은 안돼요!!) > ");
        scanner.next();
        System.out.println();
    }
}