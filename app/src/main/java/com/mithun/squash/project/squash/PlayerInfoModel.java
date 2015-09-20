package com.mithun.squash.project.squash;

/**
 * Created by mithun on 9/20/15.
 */
public class PlayerInfoModel {
    public int player_id;
    public String name;
    public String photo_path;

    public PlayerInfoModel(String name) {
        photo_path = "";
        this.name = name;
    }
}
