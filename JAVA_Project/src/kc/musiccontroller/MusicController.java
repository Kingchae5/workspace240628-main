package kc.musiccontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kc.music.Music;

public class MusicController {

    private List<Music> list = new ArrayList<>(); 
    
    public int addList(Music music) { //곡 추가에 성공하면 1을 반환한다.
        list.add(music);
        return 1;
    }
    
    public List<Music> printAll() { //리스트 반환 플레이리스트 출력
        return this.list;
    }
  
    public List<Music> searchMusic(String title) {
        List<Music> resultList = new ArrayList<>();
        
        for (Music music : list) { 
            if (music.getTitle().equalsIgnoreCase(title)) {
                resultList.add(music);
            }
        }
        
        return resultList; 
    }

    public List<Music> searchSinger(String singer) {
        List<Music> resultList = new ArrayList<>();
        
        for (Music music : list) { 
            if (music.getSinger().equalsIgnoreCase(singer)) {
                resultList.add(music);
            }
        }
        
        return resultList; 
    }

    public List<Music> removeMusic(String title) {
        List<Music> removedList = new ArrayList<>(); // 제거된 곡들을 저장할 리스트를 생성
        List<Music> toRemoveList = searchMusic(title); // 주어진 제목으로 검색하여 제거할 곡들의 리스트를 가져옴
        
        for (Music music : toRemoveList) {  // 현재 리스트에서 곡을 제거하고 성공 여부를 확인
            if (this.list.remove(music)) {
            	  // 곡이 성공적으로 제거되면 removedList에 추가
                removedList.add(music); 
            }
        }
        
        return removedList; 
    }
    
    public List<Music> setMusic(String title, Music newMusic) {
        List<Music> updatedList = new ArrayList<>();
        List<Music> toUpdateList = searchMusic(title); 
        
        for (Music oldMusic : toUpdateList) {
            int index = list.indexOf(oldMusic);
            if (index != -1) {
                list.set(index, newMusic); 
                updatedList.add(newMusic); 
            }
        }
        
        return updatedList;
    }
    
    // 무작위로 노래 하나를 선택하여 반환하는 메서드
    public Music pickMusic() {
        if (list.isEmpty()) {
            return null;  // 플레이리스트가 비어있는 경우 null 반환
        }
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());  // 무작위 인덱스 생성
        return list.get(randomIndex);  // 무작위로 선택된 노래 반환
    }
}
