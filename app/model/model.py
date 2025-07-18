import pandas as pd

class WaterModel:
    def preprocessing(self, input_data: pd.DataFrame) -> pd.DataFrame:
        # Placeholder for preprocessing logic
        print("Preprocessing data...")
        return input_data

    def predict(self, input_data: pd.DataFrame) -> list:
        # Placeholder for prediction logic
        # Returning a dummy prediction
        print("Predicting data...")
        return [1]  # Dummy prediction: Potable

water_model_instance = WaterModel()
