import os

from pydantic.v1 import BaseSettings


class Settings(BaseSettings):
    PROJECT_NAME: str = "Water Quality Prediction API"
    PROJECT_VERSION: str = "0.1.0"
    API_V1_STR: str = "/api/v1"
    PROJECT_ROOT_DIR: str = os.getenv("PROJECT_ROOT_DIR", os.path.dirname(os.path.dirname(os.path.dirname(__file__))))
    MODEL_PATH: str = os.path.join(PROJECT_ROOT_DIR, "models")
    MODEL_VAR: list = ['ph', 'Hardness', 'Solids', 'Chloramines', 'Sulfate', 'Conductivity', 'Organic_carbon', 'Trihalomethanes',
                       'Turbidity']


settings = Settings()
