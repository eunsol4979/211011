package co.micol.prj;

import co.micol.prj.board.command.BoardSelect;
import co.micol.prj.board.command.Command;
import co.micol.prj.comm.BoardMenu;

public class MainApp {

	public static void main(String[] args) {
	
		//게시판 프로젝트
//		BoardListCommand blist = new BoardListCommand();
//		blist.execute();
		
//		Command command = new BoardSelect();
//		command.execute();

		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();
	}
}
