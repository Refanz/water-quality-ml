import joblib
import pandas as pd

dataset = pd.read_csv('data/water_potability.csv').dropna()

sample_input = dataset.sample(1).drop(columns='Potability')

model = joblib.load('../models/model_svm.joblib')
scaler = joblib.load('../models/scaler.joblib')


def preprocessing(input_data):
    preprocessed_data = scaler.transform(input_data)
    preprocessed_data = pd.DataFrame(preprocessed_data, columns=sample_input.columns)
    return preprocessed_data


def predict(input_data):
    preprocessed_data = preprocessing(input_data)
    prediction_result = model.predict(preprocessed_data)
    return prediction_result


if __name__ == '__main__':
    prediction = predict(sample_input)
    print(prediction[0])
