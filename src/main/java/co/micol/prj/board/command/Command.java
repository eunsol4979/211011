package co.micol.prj.board.command;
import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.service.Impl.BoardServiceImpl;
import co.micol.prj.mybatis.BoardMybatisService;

public interface Command {
	public BoardService dao = new BoardMybatisService();
	public void execute();

}
