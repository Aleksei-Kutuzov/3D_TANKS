package com.alkut.game3dtanks.view;

import com.alkut.game3dtanks.model.Item;
import com.alkut.game3dtanks.model.World;
import com.alkut.game3dtanks.model.modelStates;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.Color;

public class WorldRender implements Disposable {
    private final World world;
    public final ModelBatch modelBatch;
    public PerspectiveCamera camera;
    private CameraInputController cameraController;
    private Environment environment;

    public WorldRender(World world) {
        this.world = world;
        this.modelBatch = new ModelBatch();
        initCamera();
        initEnvironment();
    }

    private void initCamera() {
        // Создаем перспективную камеру для 3D
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 30f, 30f); // Камера выше от объекта
        camera.lookAt(0, 0, 0);             // Смотрим в центр сцены
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        // Добавляем контроллер для управления камерой
        cameraController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraController);
    }

    private void initEnvironment() {
        environment = new Environment();
        //environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -1f, -1f));
    }

    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    public void render() {
        // Обновляем контроллер камеры
        cameraController.update();

        // Очистка экрана
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        renderItems();
    }

    private void renderItems() {
        modelBatch.begin(camera);
        for (Item item : world.items) {
            if (item.getState() == modelStates.NOSTATE) {
                modelBatch.render(item.modelInstance, environment);
            }
        }
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
    }
}
