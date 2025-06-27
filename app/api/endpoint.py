from typing import Any

from fastapi import APIRouter
from requests import Request
from starlette.responses import HTMLResponse

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
def predict(request: Request) -> Any:
    pass
