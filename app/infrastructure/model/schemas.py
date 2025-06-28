from pydantic import BaseModel


class PredictionRequest(BaseModel):
    ph: float | int
    hardness: float | int
    solids: float | int
    chloramines: float | int
    sulfate: float | int
    conductivity: float | int
    organic_carbon: float | int
    trihalomethanes: float | int
    turbidity: float | int

    class Config:
        json_schema_extra = {
            'example': {
                'ph': 1.0,
                'hardness': 1.0,
                'solids': 1.0,
                'chloramines': 1.0,
                'sulfate': 1.0,
                'conductivity': 1.0,
                'organic_carbon': 1.0,
                'trihalomethanes': 1.0,
                'turbidity': 1.0
            }
        }


class PredictionResponse(BaseModel):
    label: int
    description: str

    class Config:
        json_schema_extra = {
            'example': {
                'label': 1,
                'description': 'Potable',
            }
        }
