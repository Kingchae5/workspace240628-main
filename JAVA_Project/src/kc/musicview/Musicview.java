package kc.musicview;

import java.util.List;
import java.util.Scanner; //Scanner

public class Musicview {
	private Scanner sc = new Scanner(System.in);
	private kc.musiccontroller.MusicController mc = new kc.musiccontroller.MusicController(); // MusicController

	public void MainMenu() {
		while (true) {
			System.out.println("========== 메인 메뉴 ==========");
			System.out.println("1. 플레이리스트에 곡 추가");
			System.out.println("2. 플레이리스트 목록");
			System.out.println("3. 특정 곡 검색");
			System.out.println("4. 특정 가수 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 음악 추천");
			System.out.println("9. 종료 ");
			System.out.print("메뉴 번호 선택 : ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) { // 반복
			case 1:
				this.addlist();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 2:
				this.printAll();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 3:
				this.searchMusic();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 4:
				this.searchSinger();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 5:
				this.removeMusic();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 6:
				this.setMusic();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 7:
				this.pickMusic();
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void addlist() { // 곡을 추가하는 메서드
		System.out.println("========== 플레이리스트에 곡 추가 ==========");

		System.out.println("곡 명 : ");
		String title = sc.nextLine();

		System.out.println("가수 명 : ");
		String singer = sc.nextLine();

		int result = mc.addList(new kc.music.Music(title, singer));
		if (result == 1) { // 곡 추가에 성공하면 1을 반환한다.
			System.out.println("추가 성공"); // 1이면 추가 성공
		} else {
			System.out.println("추가 실패"); // 아니라면 추가 실패
		}
	}

	public void printAll() { // 플레이리스트(곡들)을 출력하는 메서드
		System.out.println("========== 플레이리스트 출력 ==========");
		List<kc.music.Music> list = mc.printAll();
		for (kc.music.Music music : list) { // 플레이리스트에 있는 각 곡에 대해 반복
			System.out.println("곡 명: " + music.getTitle() + ", 가수 명: " + music.getSinger()); // getTitle, getSinger 반환
		}
	}

	public void searchMusic() { // 곡을 검색하는 메서드
		System.out.println("========== 곡 검색 ==========");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();

		List<kc.music.Music> foundMusic = mc.searchMusic(title); // 리스트

		if (foundMusic != null && !foundMusic.isEmpty()) { // 검색 결과가 null 아니고, 비어 있지 않은 경우
			System.out.println("검색된 곡 목록:");
			for (kc.music.Music song : foundMusic) { // 플레이리스트의 각 곡에 대해 반복
				System.out.println("곡 명: " + song.getTitle() + ", 가수 명: " + song.getSinger()); // 곡 명과 가수 명 출력
			}
		} else {
			System.out.println("해당 곡이 플레이리스트에 없습니다.");
		}
	}

	public void searchSinger() { // 가수명을 검색하는 메서드
		System.out.println("========== 가수명으로 곡 검색 ==========");
		System.out.print("검색할 가수명: ");
		String singer = sc.nextLine();

		List<kc.music.Music> foundSongs = mc.searchSinger(singer); // 리스트

		if (foundSongs != null && !foundSongs.isEmpty()) { // 검색 결과가 null 아니고, 비어 있지 않은 경우
			System.out.println("검색된 곡 목록:");
			for (kc.music.Music song : foundSongs) { // 플레이리스트의 각 곡에 대해 반복
				System.out.println("곡 명: " + song.getTitle() + ", 가수 명: " + song.getSinger()); // 곡 명과 가수 명 출력
			}
		} else {
			System.out.println("해당 가수의 곡이 플레이리스트에 없습니다.");
		}
	}

	public void removeMusic() {
		System.out.println("========== 특정 곡 삭제 ==========");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();

		List<kc.music.Music> removedSongs = mc.removeMusic(title); // 리스트

		if (removedSongs != null && !removedSongs.isEmpty()) { // 검색 결과가 null 아니고, 비어 있지 않은 경우
			System.out.println("삭제된 곡 목록:");
			for (kc.music.Music song : removedSongs) {
				System.out.println("곡 명: " + song.getTitle() + ", 가수 명: " + song.getSinger());
				System.out.println("곡이 삭제되었습니다.");
			}
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}

	public void setMusic() {
		System.out.println("========== 특정 곡 정보 수정 ==========");
		System.out.print("검색할 곡 명 : ");
		String searchTitle = sc.nextLine();

		System.out.println("수정할 곡 명 : ");
		String newTitle = sc.nextLine();
		System.out.println("수정할 가수 명 : ");
		String newSinger = sc.nextLine();

		// mc 객체의 setMusic 메서드를 호출하여 곡 정보를 수정
		// setMusic 메서드는 검색된 제목을 가진 곡을 새로운 곡 정보로 업데이트
		// 수정된 곡들의 리스트를 반환함
		List<kc.music.Music> updatedSongs = mc.setMusic(searchTitle, new kc.music.Music(newTitle, newSinger));

		// 수정된 곡 목록이 null이 아니고 비어 있지 않은 경우
		if (updatedSongs != null && !updatedSongs.isEmpty()) {
			System.out.println("수정된 곡 목록:");
			for (kc.music.Music song : updatedSongs) {
				System.out.println("곡 명: " + song.getTitle() + ", 가수 명: " + song.getSinger());
			}
		} else {
			System.out.println("수정할 곡이 없습니다.");
		}
	}

	public void pickMusic() {
		System.out.println("========== 노래 추천 ==========");

		kc.music.Music recommendedSong = mc.pickMusic(); // 무작위로 노래를 추천

		if (recommendedSong != null) {
			System.out.println("추천된 곡: " + recommendedSong.getTitle() + " - " + recommendedSong.getSinger());
		} else {
			System.out.println("플레이리스트에 곡이 없습니다.");
		}
	}
}


		
		