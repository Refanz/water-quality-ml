from typing import Any

from fastapi import APIRouter, HTTPException
from starlette.responses import HTMLResponse

from app.service.prediction_service import prediction_service_dependency

from app.schemas.prediction_schema import PredictionRequest, PredictionResponse

root_router = APIRouter()

api_router = APIRouter()


@root_router.get("/")
def index() -> Any:
    body = (
        """
            <!DOCTYPE html>
            <html>
                <head>
                    <title>Water Quality Prediction API</title>
                </head>
                <body style='padding: 10px;'>
                    <h1>Water Quality Prediction API</h1>
                    <div>
                        Check the docs: <a href="/docs">here</a>
                    </div>   
                </body>
            </html>
        """
    )

    return HTMLResponse(content=body)


@api_router.post("/predict")
async def predict(
        model_input: PredictionRequest,
        prediction_service: prediction_service_dependency,
) -> PredictionResponse:
    if model_input is None:
        raise HTTPException(status_code=400, detail="Invalid input")

    model_input = model_input.model_dump()

    result = await prediction_service.predict(model_input)

    return PredictionResponse(
        label=result['label'],
        description=result['description']
    )
