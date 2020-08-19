/**
 * Copyright 2019 Esri
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.mycompany.app;

import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class App extends Application {

    private MapView mapView;

    public static void main(String[] args) {

        Application.launch(args);
    }

    private void setupPortalItem() {
        String portalItemId = "883cedb8c9fe4524b64d47666ed234a7";
        Portal portal = new Portal("https://www.arcgis.com");
        PortalItem portalItem = new PortalItem(portal, portalItemId);
//        System.out.println(portalItem.getLoadStatus());
        portalItem.addDoneLoadingListener(() -> {
            if (portalItem.getLoadStatus() == LoadStatus.LOADED) {
                setupFeatureLayerFromPortalItem(portalItem);

            } else {
                new Alert(Alert.AlertType.ERROR, "Portal Item: " + portalItem.getLoadError().getMessage()).show();
            }
        });

        portalItem.loadAsync();
    }

    private void setupFeatureLayerFromPortalItem(PortalItem portalItem) {
        int layerId = 0;
        FeatureLayer layer = new FeatureLayer(portalItem, layerId);
        layer.addDoneLoadingListener(() -> {
            if (layer.getLoadStatus() == LoadStatus.LOADED) {
                mapView.getMap().getOperationalLayers().add(layer);
                mapView.setViewpoint(new Viewpoint(layer.getFullExtent()));
            } else {
                new Alert(AlertType.ERROR, "Feature Layer: " + layer.getLoadError().getMessage()).show();
            }
        });
        layer.loadAsync();

    }


    @Override
    public void start(Stage stage) {

        // set the title and size of the stage and show it
        stage.setTitle("My Map App");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // create a MapView to display the map and add it to the stack pane
        mapView = new MapView();
        stackPane.getChildren().add(mapView);

        // create an ArcGISMap with the default imagery basemap
        ArcGISMap map = new ArcGISMap(Basemap.createImagery());

        // display the map by setting the map on the map view
        mapView.setMap(map);

        setupPortalItem();
    }

    /**
     * Stops and releases all resources used in application.
     */
    @Override
    public void stop() {

        if (mapView != null) {
            mapView.dispose();
        }
    }
}
