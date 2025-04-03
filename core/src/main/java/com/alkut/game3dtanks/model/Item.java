package com.alkut.game3dtanks.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;

public class Item  {


    private modelStates state;
    public ModelInstance modelInstance;

    public Item() {
        state = modelStates.NOSTATE;
        ModelBuilder modelBuilder = new ModelBuilder();
        Material material = new Material(ColorAttribute.createDiffuse(Color.GOLD));
        Model model = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("models/brick2.g3dj"));
        modelInstance = new ModelInstance(model);
        modelInstance.transform.setToRotation(Vector3.Z, 120);
        modelInstance.transform.setToTranslation(0, 0, 0);
        modelInstance.transform.setToScaling(1, 1 , 1);
    }

    public void setState(modelStates state) {
        this.state = state;
    }

    public modelStates getState() {
        return state;
    }
}
