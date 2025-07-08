import os.path

import joblib

from app.core.config import settings


class WaterQualityModel:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(WaterQualityModel, cls).__new__(cls)
            cls._instance._model = None
            cls._instance._scaler = None
            cls._instance.__load_model()
            cls._instance.__load_scaler()
        return cls._instance

    def __load_scaler(self):
        if not os.path.exists(os.path.join(settings.MODEL_PATH, 'scaler.joblib')):
            raise FileNotFoundError("Scaler is not found at: ", settings.MODEL_PATH)
        print("Loading scaler...")
        self._scaler = joblib.load(os.path.join(settings.MODEL_PATH, 'scaler.joblib'))
        print("Scaler loaded")

    def __load_model(self):
        if not os.path.exists(os.path.join(settings.MODEL_PATH, 'model_svm.joblib')):
            raise FileNotFoundError("Model is not found at: ", settings.MODEL_PATH)

        print("Loading model...")
        self._model = joblib.load(os.path.join(settings.MODEL_PATH, 'model_svm.joblib'))
        print("Model loaded.")

    def preprocessing(self, model_input):
        if self._scaler is None:
            raise RuntimeError("Scaler not loaded")

        preprocessed_input = self._scaler.transform(model_input)
        return preprocessed_input

    def predict(self, model_input):
        if self._model is None:
            raise RuntimeError("Model must be loaded.")

        prediction = self._model.predict(model_input)
        return prediction


water_model_instance = WaterQualityModel()
