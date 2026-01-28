package com.be24.api.common;

import com.be24.api.board.*;
import com.be24.api.image.ImageController;
import com.be24.api.image.ImageRepository;
import com.be24.api.image.ImageService;
import com.be24.api.user.UserController;

import java.util.HashMap;
import java.util.Map;
import com.zaxxer.hikari.HikariDataSource;

public class AppConfig {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    // DB Connection 관련 HikariDataSource 생성
    // Hikari? : DBPool을 설정할 수 있고, 연결을 유지한채 계속 통신할 수 있는 방식
    private final HikariDataSource ds = new HikariDataSource();

    private final BoardRepository boardRepository = new BoardCpRepositoryImpl(ds);
    private final BoardService boardService = new BoardService(boardRepository);
    private final BoardController boardController = new BoardController(boardService);
    private final ImageRepository imageRepository = new ImageRepository();
    private final ImageService imageService = new ImageService(imageRepository);
    private final ImageController imageController = new ImageController(imageService);
    private final UserController userController = new UserController();



    // 처음 객체가 생성될 때 controllerMap에 uri를 키로 컨트롤러 객체를 값으로 저장
    public AppConfig() {
        ds.setJdbcUrl("jdbc:mariadb://10.10.10.100:3306/test");
        ds.setUsername("root");
        ds.setPassword("qwer1234");

        controllerMap.put("/board/create", boardController);
        controllerMap.put("/board/read", boardController);
        controllerMap.put("/image/upload", imageController);
        controllerMap.put("/user/signup", userController);
        controllerMap.put("/user/login", userController);
    }

    // 특정 uri를 이용해서 특정 컨트롤러 객체를 반환하는 메소드
    public Controller getController(String uri) {
        return controllerMap.get(uri);
    }
}
