from typing import Annotated

import pandas as pd
from fastapi import Depends

from app.core.config import settings
from app.model.model import water_model_instance


def convert_model_input_to_dataframe(model_input):
    converted_input = pd.DataFrame(model_input, index=[0])
    converted_input.columns = settings.MODEL_VAR

    return converted_input


class PredictionService:
    def __init__(self, model_instance=water_model_instance):
        self.model = model_instance

    async def predict(self, model_input):
        model_input = convert_model_input_to_dataframe(model_input)
        processed_input = self.model.preprocessing(model_input)

        prediction = self.model.predict(processed_input)[0]

        result = {
            'label': prediction,
            'description': 'Potability' if prediction == 1 else 'Not-Potability',
        }

        return result


def get_prediction_service():
    return PredictionService()


prediction_service_dependency = Annotated[PredictionService, Depends(get_prediction_service)]
