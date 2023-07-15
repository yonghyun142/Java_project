package project1;

import java.util.Scanner;

public class Service {
	public static void main(String[] args)throws Exception {
		Scanner scanner = new Scanner(System.in); //입력 받는 객체
		DAO dao = new DAO(); //게시판 접근 객체
		
		//게시판 프로그램
		while(true) {
			dao.getBoardList(); //게시판 목록 불러오기
			int answer = Integer.parseInt(scanner.nextLine());
			
			if(answer == 1) { //새글작성
				dao.boardInsert();
			}else if(answer == 2) { //상세보기
				System.out.println("보고 싶은 게시글 번호를 선택하세요.>>");
				int select = Integer.parseInt(scanner.nextLine());
				dao.boardDetail(select); //선택한 글의 상세페이지 출력
			}else if(answer == 3) { //수정하기
				System.out.println("수정할 글 번호를 선택하세요.>>");
				int select = Integer.parseInt(scanner.nextLine());
				dao.boardUpdate(select); //선택한 글 수정
			}else if(answer == 4) { //삭제하기
				System.out.println("삭제할 글 번호를 선택하세요.>>");
				int select = Integer.parseInt(scanner.nextLine());
				dao.boardDelete(select); //선택한 글 삭제
			}else if(answer == 5) { //파일기능
				System.out.println("1.파일 읽기, 2. 파일 쓰기[덮어쓰기]) : ");
				answer = Integer.parseInt(scanner.nextLine());
				if(answer == 1) { //파일 읽기
					dao.txtRead();
				} else if(answer == 2) { //파일 쓰기
					dao.txtWrite();
				} else { // 그 외의 입력을 한 경우
					System.out.println("파일처리 종료");
				}
			}else if(answer == 6) { //종료
				break;
			}else { //그 외의 입력을 한 경우
				System.out.println("잘못 입력하였습니다.");
			}	
			//while문 밖
		}
		System.out.println("게시판 프로그램이 종료되었습니다.");
	}
	
}