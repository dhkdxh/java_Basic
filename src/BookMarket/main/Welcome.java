package BookMarket.main;

import BookMarket.bookitem.Book;
import BookMarket.cart.Cart;
import BookMarket.member.Admin;
import BookMarket.member.User;

import java.util.*;

public class Welcome {
    static Scanner sc = new Scanner(System.in);
    static final int NUM_BOOK = 3;
    static final int NUM_ITEM = 7;
    static User mUser;
    static Cart mCart = new Cart();

    public static void main(String[] args) {

        Book[] mBookList = new Book[NUM_BOOK];

        System.out.print("당신의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("당신의 연락처를 입력하세요 : ");
        int phone = Integer.parseInt(sc.nextLine());

        mUser = new User(name, phone);

        int input = 0;
        while (input != 8) {
            menuIntroduction();

            input = sc.nextInt();

            switch (input) {
                case 1:
                    menuGuestInfo();
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAddItem(mBookList);
                    break;
                case 5:
                    menuCartRemoveItemCount();
                    break;
                case 6:
                    menuCartRemoveItem();
                    break;
                case 7:
                    menuCartBill();
                    break;
                case 8:
                    menuExit();
                    break;
                case 9:
                    menuAdminLogin();
                    break;
                default:
                    System.out.println("1부터 9까지의 숫자를 입력하세요.");
            }
        }
    }

    public static void menuGuestInfo() {
        System.out.println("현재 고객 정보 :");
        System.out.printf("이름 %s \t 연락처 %s\n", mUser.getName(), mUser.getPhone());
    }

    public static void menuCartItemList() {
        if (Cart.mCartCount >= 0) {
            mCart.printCart();
        }
    }

    public static void menuCartClear() {
        if (Cart.mCartCount == 0) System.out.println("장바구니에 항목이 없습니다.");
        else {
            System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
            String str = sc.nextLine();

            if (str.toUpperCase().equals("Y")) {
                System.out.println("장바구니의 모든 항목을 삭제했습니다.");
                mCart.deleteBook();
            }
        }
    }

    public static void menuCartAddItem(Book[] booklist) {
        System.out.println("장바구니에 항목 추가하기 : ");
        BookList(booklist);
        mCart.printBookList(booklist);

        while (true) {
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            String input = sc.nextLine();

            int numId = -1;
            boolean flag = false;

            for (int i = 0; i < NUM_BOOK; i++) {
                if (input.equals(booklist[i].getBookId())) {
                    numId = i;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("장바구니에 추가하겠습니까? Y | N");
                input = sc.nextLine();

                if (input.toUpperCase().equals("Y")) {
                    System.out.println(booklist[numId].getBookId() + " 도서가 장바구니에 추가되었습니다.");
                    if (!mCart.isCartInBook(booklist[numId].getBookId())) {
                        mCart.insertBook(booklist[numId]);
                    }
                    break;
                } else System.out.println("다시 입력해주세요.");
            }
        }
    }
        public static void menuCartRemoveItemCount () {

        }

        public static void menuCartRemoveItem () {
            if (Cart.mCartCount == 0) System.out.println("장바구니에 항목이 없습니다.");
            else {
                menuCartItemList();
                boolean quit = false;
                while (!quit) {
                    System.out.println("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
                    String str = sc.nextLine();
                    boolean flag = false;
                    int numId = -1;

                    for (int i = 0; i < Cart.mCartCount; i++) {
                        if (str.equals(mCart.mCartItem[i].getBookID())) {
                            numId = i;
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N ");
                        str = sc.nextLine();
                        if (str.toUpperCase().equals("Y")) {
                            System.out.println(mCart.mCartItem[numId].getBookID() + " 장바구니에서 도서가 삭제되었습니다.");
                            mCart.removeCart(numId);
                        }
                        quit = true;
                    } else System.out.println("다시 입력해 주세요.");
                }
            }
        }
        public static void menuCartBill () {

        }
        public static void menuExit () {
            System.out.println("프로그램이 종료됩니다");
        }

        public static void menuIntroduction () {
            System.out.println("****************************************************");
            System.out.println("       Welcome to Shopping Mall");
            System.out.println("       Welcome to Book Market!");
            System.out.println("****************************************************");
            System.out.println(" 1. 고객 정보 확인하기       4. 바구니에 항목 추가하기");
            System.out.println(" 2. 장바구니 상품 목록 보기   5. 장바구니의 항목 수량 줄이기");
            System.out.println(" 3. 장바구니 비우기          6. 장바구니의 항목 삭제하기");
            System.out.println(" 7. 영수증 표시하기          8. 종료");
            System.out.println(" 9. 관리자 로그인");
            System.out.println("****************************************************");
            System.out.print("메뉴 번호를 선택해주세요 ");
        }

        public static void BookList (Book[] booklist){

            booklist[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000);
            booklist[0].setAuthor("송미영");
            booklist[0].setDescription("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
            booklist[0].setCategory("IT전문서");
            booklist[0].setReleaseDate("2018/10/08");


            booklist[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000);
            booklist[1].setAuthor("우재남");
            booklist[1].setDescription("실습 단계별 명쾌한 멘토링!");
            booklist[1].setCategory("IT전문서");
            booklist[1].setReleaseDate("2022/01/22");

            booklist[2] = new Book("ISBN1236", "스크래치", 22000);
            booklist[2].setAuthor("고광일");
            booklist[2].setDescription("컴퓨팅 사고력을 키우는 블록 코딩");
            booklist[2].setCategory("컴퓨터입문");
            booklist[2].setReleaseDate("2019/06/10");
        }

        public static boolean isCartInBook (String bookId){
            return mCart.isCartInBook(bookId);
        }

        public static void menuAdminLogin () {
            System.out.println("관리자 정보를 입력하세요.");

            System.out.print("아이디 : ");
            String adminId = sc.next();
            System.out.print("비밀번호 : ");
            String adminPW = sc.next();

            Admin admin = new Admin(mUser.getName(), mUser.getPhone());
            if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPassword())) {
                System.out.println("이름 " + admin.getName() + "  연락처 " + admin.getPhone());
                System.out.println("아이디 " + admin.getId() + "  비밀번호 " + admin.getPassword());
            } else System.out.println("관리자 정보가 일치하지 않습니다.");
        }
}